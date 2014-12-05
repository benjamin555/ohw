<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<table id="items" class="table table-striped table-bordered">
						<tr>
							<td></td>
							<td>编号</td>
							<td>描述</td>
							<td>sheet跳过行数</td>
						</tr>
						<s:iterator value="qstatements" var="q">
							<tr class="item">
								<td>
								 <input type="checkbox" name="ids" value="<s:property value="#q.id" />"></input>
								</td>
								<td><a
									href="<%=basePath%>qstatement!forImport.action?qstatement.id=<s:property value="#q.id" />"><s:property
											value="#q.id" /> </a>
								</td>
								<td><s:property value="#q.description" /></td>
								<td><s:property value="#q.skipRowStr" /></td>
							</tr>
						</s:iterator>
</table>