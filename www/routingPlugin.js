/*global cordova, module*/
module.exports = {
    go: function (route, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "BAMRouting", "go", [route.segue, route.withData]);
    }
};
