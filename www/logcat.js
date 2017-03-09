module.exports = {
	sendLogs:function(arg,successCB,failureCB){
		cordova.exec(successCB, failureCB, "LogCat","sendLogs", [arg]);
	}
};

