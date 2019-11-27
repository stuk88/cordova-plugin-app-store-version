#import <Cordova/CDVPlugin.h>

@interface CheckAppStoreVersion : CDVPlugin
- (void)checkAppUpdate:(CDVInvokedUrlCommand*)command;
@end
