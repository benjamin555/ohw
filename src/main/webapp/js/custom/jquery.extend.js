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