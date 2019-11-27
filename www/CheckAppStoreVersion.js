var exec = require('cordova/exec');

exports.checkAppUpdate = function(success, error, packageName) {
    exec(success, error, "CheckAppStoreVersion", "checkAppUpdate",  [packageName]);
};
