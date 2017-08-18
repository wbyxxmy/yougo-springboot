package com.yexj.yougo.common.baseMapper;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by xinjian.ye on 2017/5/5.
 * Time: 0:19
 */
public class BaseMapperGeneratorPlugin extends PluginAdapter {
    private String baseDaoPath="";
    private String selectByParam = "selectByParam";
    private String selectCountByParam = "selectCountByParam";

    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
    }
//    private void addField(String fieldName, FullyQualifiedJavaType fieldType,
//                          TopLevelClass topLevelClass) {
//        Field tmpField = new Field(fieldName, fieldType);
//        tmpField.setVisibility(JavaVisibility.PRIVATE);
//        topLevelClass.addField(tmpField);
//
//        Method setMethod = new Method();
//        setMethod.setName("set" + fieldName.toUpperCase().substring(0, 1)
//                + fieldName.substring(1));
//        Parameter param = new Parameter(fieldType, fieldName);
//        setMethod.addParameter(param);
//        setMethod.setVisibility(JavaVisibility.PUBLIC);
//        setMethod.addBodyLine("this." + fieldName + "=" + fieldName + ";");
//
//        topLevelClass.addMethod(setMethod);
//
//        Method getMethod = new Method();
//        getMethod.setName("get" + fieldName.toUpperCase().substring(0, 1)
//                + fieldName.substring(1));
//
//        getMethod.setReturnType(fieldType);
//        getMethod.setVisibility(JavaVisibility.PUBLIC);
//        getMethod.addBodyLine("return this." + fieldName + ";");
//
//        topLevelClass.addMethod(getMethod);
//
//    }
//
//    @Override
//    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
//                                              IntrospectedTable introspectedTable) {
//        FullyQualifiedJavaType intType = FullyQualifiedJavaType
//                .getIntInstance();
//        addField("pageIndex", intType, topLevelClass);
//        addField("pageSize", intType, topLevelClass);
//
//        Method getSkipCountMethod = new Method();
//        getSkipCountMethod.setName("getSkipRecordCount");
//
//        getSkipCountMethod.setReturnType(intType);
//        getSkipCountMethod.setVisibility(JavaVisibility.PUBLIC);
//        getSkipCountMethod
//                .addBodyLine("return (this.pageIndex-1)*this.pageSize;");
//
//        topLevelClass.addMethod(getSkipCountMethod);
//
//        Method getEndRecordIndexMethod = new Method();
//        getEndRecordIndexMethod.setName("getEndRecordCount");
//
//        getEndRecordIndexMethod.setReturnType(intType);
//        getEndRecordIndexMethod.setVisibility(JavaVisibility.PUBLIC);
//        getEndRecordIndexMethod
//                .addBodyLine("return this.pageIndex*this.pageSize;");
//
//        topLevelClass.addMethod(getEndRecordIndexMethod);
//
//
//        Method newConstructorMethod = new Method();
//        newConstructorMethod.setConstructor(true);
//        newConstructorMethod.addParameter(new Parameter(intType, "pageSize"));
//        newConstructorMethod.addParameter(new Parameter(intType, "pageIndex"));
//        newConstructorMethod.addBodyLine("this();");
//        newConstructorMethod.addBodyLine("this.pageSize=pageSize;");
//        newConstructorMethod.addBodyLine("this.pageIndex=pageIndex;");
//        newConstructorMethod.setVisibility(JavaVisibility.PUBLIC);
//        newConstructorMethod.setName(topLevelClass.getType().getShortName());
//
//        topLevelClass.addMethod(newConstructorMethod);
//        return true;
//    }
    /**
     * 生成dao
     */
    @Override
    public boolean clientGenerated(Interface interfaze,
                                   TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String columnsType="java.lang.String";
        //动态获取当前表的主键类型，如果有联合主键，默认取联合主键的第一列（可能存在问题）
        //主键为空则默认为String类型
        if(introspectedTable.getPrimaryKeyColumns()!=null && introspectedTable.getPrimaryKeyColumns().size()>0){
            columnsType=introspectedTable.getPrimaryKeyColumns().get(0).getFullyQualifiedJavaType().toString();
        }
        if(properties!=null && properties.size()>0){
            baseDaoPath=properties.get("baseDaoPath").toString();
        }
        FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType("BaseMapper<"
                 + introspectedTable.getBaseRecordType() + ","
                + columnsType  + ">");
        FullyQualifiedJavaType imp = new FullyQualifiedJavaType(
                baseDaoPath);
        /**
         * 添加 extends MybatisBaseMapper
         */
        interfaze.addSuperInterface(fqjt);

        /**
         * 添加import com.yexj.yougo.common.baseMapper.baseMapper;
         */
        interfaze.addImportedType(imp);
        /**
         * 方法不需要
         */
        interfaze.getMethods().clear();
        interfaze.getAnnotations().clear();

        //添加按按条件搜索,和按条件返回按条件搜索记录数量
        String baseRecordType = introspectedTable.getBaseRecordType();
        //生成参数
        List<Parameter> parameters = new ArrayList<>();
        Parameter parameter = new Parameter(new FullyQualifiedJavaType(baseRecordType),"param");
        parameters.add(parameter);
        //生成返回类型
        FullyQualifiedJavaType returnTpye = FullyQualifiedJavaType.getNewListInstance();
        returnTpye.addTypeArgument(new FullyQualifiedJavaType(baseRecordType));

        interfaze.addMethod(newMethod(selectByParam, parameters
                , returnTpye));
        interfaze.addMethod(newMethod(selectCountByParam, parameters
                , FullyQualifiedJavaType.getIntInstance()));

        interfaze.addImportedType(new FullyQualifiedJavaType("java.util.List"));
        return true;
    }
    private Method newMethod(String methodName, List<Parameter> parameters, FullyQualifiedJavaType returnType) {
        Method resultMethod = new Method(methodName);
        resultMethod.setReturnType(returnType);
        for(Parameter parameter : parameters){
            resultMethod.addParameter(parameter);
        }
        return resultMethod;
    }

    /**
     * 生成mapper.xml
     * @param document
     * @param introspectedTable
     * @return
     */
    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {

        XmlElement parentElement = document.getRootElement();

        String whereId = new String("Select_Where_Condition");
        List<IntrospectedColumn> list= introspectedTable.getAllColumns();
        parentElement.addElement(generateSqlWhere(whereId, list));
//        if (introspectedTable.getRules().generateBaseRecordClass()) {
//            baseRecordType = introspectedTable.getBaseRecordType();
//        } else {
//            baseRecordType = introspectedTable.getPrimaryKeyType();
//        }
        String baseRecordType = introspectedTable.getBaseRecordType();
        String tableName = introspectedTable.getTableConfiguration().getTableName();
        parentElement.addElement(generateSelect(selectByParam, baseRecordType, tableName, whereId, true));
        parentElement.addElement(generateSelect(selectCountByParam, baseRecordType, tableName, whereId, false));
        return true;
    }
    private XmlElement generateSelect(String id, String baseRecordType, String TableName, String whereId, boolean cluList) {
        XmlElement selectElement = new XmlElement("select");
        selectElement.addAttribute(new Attribute("id", id));
        selectElement.addAttribute(new Attribute("parameterType", baseRecordType));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SELECT\n    ");
        if(cluList) {
            selectElement.addAttribute(new Attribute("resultMap", "BaseResultMap"));
            stringBuffer.append("<include refid=\"Base_Column_List\"/>\n");
        }
        else {
            selectElement.addAttribute(new Attribute("resultType", "java.lang.Integer"));
            stringBuffer.append("COUNT(*)\n");
        }
        stringBuffer.append("    FROM "+ TableName + "\n    <include refid=\"" + whereId + "\"/>")
;
        selectElement.addElement(new TextElement(stringBuffer.toString()));

        return selectElement;
    }
    private XmlElement generateSqlWhere(String whereId, List<IntrospectedColumn> list) {
        XmlElement sqlElement = new XmlElement("sql");
        sqlElement.addAttribute(new Attribute("id", whereId));
        XmlElement whereElement = new XmlElement("where");
        for(IntrospectedColumn introspectedColumn: list) {
            StringBuffer column = new StringBuffer(introspectedColumn.getActualColumnName());
            StringBuffer property = new StringBuffer(introspectedColumn.getJavaProperty());
            //StringBuffer property = new StringBuffer(MyBatis3FormattingUtilities.getSelectListPhrase(introspectedColumn.getJavaProperty()));
            XmlElement ifElement = new XmlElement("if");
            ifElement.addAttribute(new Attribute("test", property + " != null and " + property + " !='' "));
            ifElement.addElement(new TextElement("and " + column + "=#{" + property + "}"));
            whereElement.addElement(ifElement);
        }
        sqlElement.addElement(whereElement);

        return sqlElement;
    }
}
