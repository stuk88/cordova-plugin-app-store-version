var exec = require('cordova/exec');

exports.checkAppUpdate = function(success, error, packageName) {
    console.log("checkAppUpdate.js called!");
    exec(success, error, "AppUpdate", "checkAppUpdate",  [packageName]);
};
