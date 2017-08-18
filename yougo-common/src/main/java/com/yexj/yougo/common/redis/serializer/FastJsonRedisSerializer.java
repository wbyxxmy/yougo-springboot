package com.yexj.yougo.common.redis.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;
import java.util.*;

import static com.alibaba.fastjson.parser.Feature.AllowSingleQuotes;
import static com.alibaba.fastjson.parser.Feature.DisableASM;
import static com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName;
import static com.alibaba.fastjson.serializer.SerializerFeature.WriteDateUseDateFormat;

/**
 * Title: Class FastjsonSerializer Description:
 * <p>
 * {@link ObjectSerializer} that can read and write JSON using <a
 * href="https://github.com/alibaba/fastjson/wiki">FastJSON's</a> {@link JSON}.
 * </p>
 *
 * <p>
 * <b>Note:</b>Null objects are serialized as empty arrays and vice versa.
 * </p>
 *
 * @author guoqiang.zhao
 * @email guoqiang.zhao@chinaredstar.com
 * @version 1.0.0
 * @since
 */
public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {

	private static final byte[] EMPTY_ARRAY = new byte[0];
	
	private final Charset charset=DEFAULT_CHARSET;
	
	/**
	 * JSON charset is UTF-8
	 */
	private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

	private static final SerializerFeature[] DEFAULT_SERIALIZER_FEATURES = new SerializerFeature[] {
			WriteClassName, WriteDateUseDateFormat };

	private static final Feature[] DEFAULT_FEATURES = new Feature[] {
			AllowSingleQuotes, DisableASM};

	private SerializerFeature[] serializerFeatures;

	private Feature[] features;

	private SerializerFeature[] getSerializerFeatures() {
		if (serializerFeatures == null || serializerFeatures.length == 0) {
			serializerFeatures = DEFAULT_SERIALIZER_FEATURES.clone();
		}
		return serializerFeatures;
	}

	private Feature[] getFeatures() {
		if (features == null || features.length == 0) {
			features = DEFAULT_FEATURES.clone();
		}
		return features;
	}

	public FastJsonRedisSerializer() {
	}

	public T deserialize(String json, Class<T> clazz) {
		if (StringUtils.isBlank(json)) {
			return null;
		}
		return JSON.parseObject(json, clazz, this.getFeatures());
	}

	@Override
	public byte[] serialize(Object t) {
		if (t == null) {
			return EMPTY_ARRAY;
		}
		try {
			Object converted = convertUnmodifiable(t);
			return JSON.toJSONBytes(converted, this.getSerializerFeatures());
		} catch (Exception ex) {
			throw new SerializationException("Could not write JSON: "
					+ ex.getMessage(), ex);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T deserialize(byte[] bytes) throws SerializationException {
		if (isEmpty(bytes)) {
			return null;
		}
		try {
			return (T) JSON.parse(bytes,0,bytes.length,charset.newDecoder(), this.getFeatures());
		} catch (Exception ex) {
			throw new SerializationException("Could not read JSON: "
					+ ex.getMessage(), ex);
		}
	}

	public void setSerializerFeatures(SerializerFeature[] serializerFatures) {
		this.serializerFeatures = ArrayUtils.clone(serializerFatures);
	}

	public void setFeatures(Feature[] features) {
		this.features = ArrayUtils.clone(features);
	}

	private static boolean isEmpty(byte[] data) {
		return (data == null || data.length == 0);
	}

	protected Object convertUnmodifiable(Object object) {

		String className = object.getClass().getName();

		if ("java.util.Collections$UnmodifiableMap".equals(className)) {

			return new HashMap<Object, Object>((Map<?, ?>) object);
		}

		if ("java.util.Collections$UnmodifiableList".equals(className)) {

			return new ArrayList<Object>((List<?>) object);
		}

		if ("java.util.Collections$UnmodifiableSet".equals(className)) {

			return new HashSet<Object>((Set<?>) object);
		}

		return object;
	}

	

	
	
	
	
}
