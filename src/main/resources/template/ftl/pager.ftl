<input type="hidden"  name="page.pageNo" id="spPageNo"  value="${pageNo}"/>
<script type="text/javascript">

	function onPagerPrevious(){
	   $("#spPageNo").val(${pageNo-1});
	   $("#${formId}").attr("action","${url}");
	   $("#${formId}").submit();
	}
	
	function onPagerNext(){
	    $("#spPageNo").val(${pageNo+1});
	    $("#${formId}").attr("action","${url}");
	    $("#${formId}").submit();
	}
</script>
<nav>
<ul class="pager">
	<#if preDisabled>
	<li class="previous disabled"><a href="javascript:void(0);" >&larr; 上一页</a>
	</li>
	<#else> 
	<li class="previous"><a href="javascript:void(0);" onclick="onPagerPrevious()" >&larr; 上一页</a>
	</li>
	</#if>
	<#if nextDisabled >
	<li class="next disabled"><a href="javascript:void(0);">下一页 &rarr;</a>
	</li>
	<#else> 
	<li class="next"><a href="javascript:void(0);" onclick="onPagerNext()">下一页 &rarr;</a>
	</li>
	</#if>
</ul>
</nav>
