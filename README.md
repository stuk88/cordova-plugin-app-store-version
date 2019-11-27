# Purpose:
The cordova-plugin-app-update has been modified by kharryman to SIMPLY return the latest version of the app from either google play store, or iTunes App store.

![travis](https://travis-ci.org/vaenow/cordova-plugin-app-update.svg?branch=master)  

[![NPM](https://nodei.co/npm/cordova-plugin-app-update.png?downloads=true&downloadRank=true)](https://nodei.co/npm/cordova-plugin-app-update/)

# cordova-plugin-app-update
App updater for Cordova/PhoneGap

# Install

### Latest published version on npm (with Cordova CLI >= 5.0.0) 

> `"cordova-android": "6.3.0"`

`cordova plugin add cordova-plugin-app-update-version --save`

# Usage

- Simple:
```js
        window.AppUpdate.checkAppUpdate(
          function(latestVersion){
            console.log("APP UPDATE SUCCESS latestVersion= " + latestVersion);
            deferred.resolve(latestVersion);
          },
          function(fail){
            console.log("APP UPDATE FAIL = " + JSON.stringify(fail));
            deferred.resolve(false);
          }, packageName, {}
        );
```


# Platforms
Android and IOS

# License
MIT

# :snowflake: :beers:

* Please let me know if you have any questions.


