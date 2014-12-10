

/**
 * 
 * @param {} eventName jquery event name
 * @return {} jquery set
 */
$.fn.unbindEx = function (eventName){
	// this referred to jquery set
	return this.each(function(){
			this["on"+eventName] = null;	
		}
	);
}


$.fn.vals = function (){
	var vals = [];
	this.each(function(){
			vals.push($(this).val());	
		}
	);
	return vals;
}

$.fn.getInputByName = function (name){
	var str = "input[name='"+name+"']";
	return this.filter(str);
}

/**
 * 
 * @param {} eventName jquery event name
 * @return {} jquery set
 */
$.fn.unbindEx = function (eventName){
	// this referred to jquery set
	return this.each(function(){
			this["on"+eventName] = null;	
		}
	);
}


$.fn.texts = function (){
	var vals = [];
	this.each(function(){
			vals.push($(this).text());	
		}
	);
	return vals;
}

/**
 * 解析json为hidden数组
 */
$.parseHidden = function (json){
	var hiddens = [];
	for(var key in json){ 
		var value = json[key];
		var hidden=$("<input type='hidden' />");
		hidden.attr("name='"+key+"'");
		hidden.attr("value='"+value+"'");
		hiddens.push(hidden);
	}
	return hiddens;
}