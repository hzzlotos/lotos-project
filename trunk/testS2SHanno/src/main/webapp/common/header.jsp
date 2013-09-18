<%@ page contentType="text/html;charset=UTF-8" %> 
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 
<%@ taglib prefix="authority" uri="http://www.exam.com/tags/authority"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
	<script type="text/javascript">
	$(document).ready(function() {
		var now = $('meta[name="menu"]').attr("content");
		try {
			if(now.indexOf("_")>0) {
				$("#"+now).addClass("sub_nav_focus");
				$("#subjectpool").addClass("nav_focus");
			} else {
				$("#"+now).addClass("nav_focus");
			}
		} catch(e){
		}
 
		//为科目库下拉列表选中的科目库重新赋值
		$("#topSubjectPoolId").bind("change",function() {
			var subjectPoolId = $("#topSubjectPoolId").val(); 
			 
			if(subjectPoolId) {
				window.location.href='${ctx}/pool/projectpool!changeSubjectpool.action?subjectPoolId='+subjectPoolId;
			} 
		});
	});

	//判断科目库是否为空
	function justIsExistsSub(aId,hrefVal){
		var len = $("select[name='topSubjectPoolId'] option").length;
		if(len==0){
			alert("请添加科目库");
			return;
		}else
			$("#"+aId).attr("href",hrefVal);
	}
//-->
</script> 
<p><span class="h2info rr"><security:authentication property="name"/> 您好， [<a href="${ctx }/logout" style="outline:none;blr:expression(this.onFocus=this.blur())">退出登录</a>]</span><h2><common:prop name="project.name"  propfilename="sysconfig.properties" defaultvalue="题库组卷管理系统" /></h2></p>
<div class="nav">
	<h4 title="${topProjectPool.name}">项目库：<common:cut len="14" string="${topProjectPool.name}" />（编号：${topProjectPool.serialNo}）</h4>
	<span id="" class="nav_focus">
		选择科目库<s:select list="topSubPoolsVLists" listKey="label" listValue="value" value="#session.subjectPoolId" name="topSubjectPoolId" id="topSubjectPoolId" 
			  theme="simple" cssStyle="padding:0;"/>
	</span> 
	<authority:auth authfunc="ROLE_科目库/专家用户管理" subjectPoolId="${sessionScope.subjectPoolId}" >
	<span id="user"><a href="${ctx}/pool/subjectuser.action" style="outline:none;blr:expression(this.onFocus=this.blur())">用户管理</a></span>
	</authority:auth>
	<authority:auth authfunc="ROLE_组卷需求导入" subjectPoolId="${sessionScope.subjectPoolId}" >
	<span id="assemble"><a href="${ctx}/demand/examdemand.action" style="outline:none;blr:expression(this.onFocus=this.blur())">组卷汇总</a></span>
	</authority:auth>
	<authority:auth authfunc="ROLE_科目库总览" subjectPoolId="${sessionScope.subjectPoolId}" >
	<span id="subject"><a href="${ctx}/pool/subjectpool.action" style="outline:none;blr:expression(this.onFocus=this.blur())">各科目库总览</a></span>
	</authority:auth>
   </div>
	<div id="header" class="sub_nav">
	<authority:auth authfunc="ROLE_题型自定义" subjectPoolId="${sessionScope.subjectPoolId}" >
    <a id="subjectpool_base" onclick="justIsExistsSub('subjectpool_base','${ctx}/base/itembase.action');" style="outline:none;blr:expression(this.onFocus=this.blur())">基础定义</a>
    </authority:auth>
    	<authority:auth authfunc="ROLE_知识体系管理" subjectPoolId="${sessionScope.subjectPoolId}" >
    <a id="subjectpool_point" onclick="justIsExistsSub('subjectpool_point','${ctx}/base/knowledgepoint.action');" style="outline:none;blr:expression(this.onFocus=this.blur())">知识体系</a>
    </authority:auth>
    	<authority:auth authfunc="ROLE_试题管理" subjectPoolId="${sessionScope.subjectPoolId}" >
    <a id="subjectpool_subjectList" onclick="justIsExistsSub('subjectpool_subjectList','${ctx}/subject/formal-subject.action');" style="outline:none;blr:expression(this.onFocus=this.blur())">试题管理</a>
    </authority:auth>
    	<authority:auth authfunc="ROLE_试题添加" subjectPoolId="${sessionScope.subjectPoolId}" >
    <a id="subjectpool_subjectAdd" onclick="justIsExistsSub('subjectpool_subjectAdd','${ctx}/subject/seed-subject.action');" style="outline:none;blr:expression(this.onFocus=this.blur())">试题录入</a>
    </authority:auth>
    	<authority:auth authfunc="ROLE_试题审核" subjectPoolId="${sessionScope.subjectPoolId}" >
    <a id="subjectpool_subjectCheck" onclick="justIsExistsSub('subjectpool_subjectCheck','${ctx}/subject/seedsubjectcheck.action');" style="outline:none;blr:expression(this.onFocus=this.blur())">试题审核</a>
    </authority:auth>
    	<authority:auth authfunc="ROLE_卷库组卷" subjectPoolId="${sessionScope.subjectPoolId}" >
    <a id="subjectpool_dem" onclick="justIsExistsSub('subjectpool_dem','${ctx}/demand/sub-demand.action');" style="outline:none;blr:expression(this.onFocus=this.blur())">题库组卷</a>
    </authority:auth>
    	<authority:auth authfunc="ROLE_题库组卷模板管理" subjectPoolId="${sessionScope.subjectPoolId}" >
	<a id="subjectpool_tem" onclick="justIsExistsSub('subjectpool_tem','${ctx}/rule/template.action');" style="outline:none;blr:expression(this.onFocus=this.blur())">组卷模板</a>
	</authority:auth>
<!--		<authority:auth authfunc="ROLE_题库组卷" subjectPoolId="${sessionScope.subjectPoolId}" >-->
<!--	<a id="subjectpool_use" onclick="justIsExistsSub('subjectpool_use','');" href="#" style="outline:none;blr:expression(this.onFocus=this.blur())">人工组卷</a>-->
<!--	</authority:auth>-->
		<authority:auth authfunc="ROLE_组卷审核" subjectPoolId="${sessionScope.subjectPoolId}" >
	<a id="subjectpool_ver" onclick="justIsExistsSub('subjectpool_ver','${ctx}/demand/subdemandverify.action');" style="outline:none;blr:expression(this.onFocus=this.blur())">组卷审核</a>
	</authority:auth>
</div>