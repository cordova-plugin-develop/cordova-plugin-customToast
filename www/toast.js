var exec = require('cordova/exec');

module.exports = {
    javaShow: function() {
        exec(null, null, "CustomToast", "javaShow", []);
    },

    javaShowJs: function(text, lenth) {
         exec(null, null, "CustomToast", "javaShowJs", [text, lenth]);
    },

    jsShowJava: function(success, error) {
	    exec(success, error, "CustomToast", "jsShowJava", []);
    },

    jsShowJs: function(text, success, error) {
	    exec(success, error, "CustomToast", "jsShowJs", [text]);
	},

	openVideo: function(content){
        exec(null, null, "CustomToast", "openVideo", [content]);
	}
};
