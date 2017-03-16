module.exports = {
	sendLogs:function(params,successCB,failureCB){
		cordova.exec(successCB, failureCB, "LogCat","sendLogs", [params]);
	}
};

