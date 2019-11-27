#import <Cordova/CDVPlugin.h>

@interface AppUpdate : CDVPlugin
- (void)checkAppUpdate:(CDVInvokedUrlCommand*)command;
@end
