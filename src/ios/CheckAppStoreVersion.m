#import "CheckAppStoreVersion.h"
#import <Cordova/CDVPlugin.h>

@implementation CheckAppStoreVersion

- (void)checkAppUpdate:(CDVInvokedUrlCommand*)command {
    CDVPluginResult *pluginResult = nil;
    NSDictionary* infoDictionary = [[NSBundle mainBundle] infoDictionary];
    NSString* appID = infoDictionary[@"CFBundleIdentifier"];
    NSURL* url = [NSURL URLWithString:[NSString stringWithFormat:@"http://itunes.apple.com/lookup?bundleId=%@", appID]];
    NSData* data = [NSData dataWithContentsOfURL:url];
    NSDictionary* lookup = [NSJSONSerialization JSONObjectWithData:data options:0 error:nil];
    NSString* appStoreVersion = NULL;
    if ([lookup[@"resultCount"] integerValue] == 1){
        appStoreVersion = lookup[@"results"][0][@"version"];
        //NSString* currentVersion = infoDictionary[@"CFBundleShortVersionString"];
        NSLog(@"App Version = [%@]", appStoreVersion);
    }else{
      appStoreVersion = @"FALSE";
    }
    pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:appStoreVersion];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
