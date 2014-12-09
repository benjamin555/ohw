<nav>
<ul class="pager">
	<#if preDisabled>
	<li class="previous disabled"><a href="${preUrl}" >&larr; 上一页</a>
	</li>
	<#else> 
	<li class="previous"><a href="${preUrl}" >&larr; 上一页</a>
	</li>
	</#if>
	<#if nextDisabled >
	<li class="next disabled"><a href="${nextUrl}">下一页 &rarr;</a>
	</li>
	<#else> 
	<li class="next"><a href="${nextUrl}">下一页 &rarr;</a>
	</li>
	</#if>
</ul>
</nav>