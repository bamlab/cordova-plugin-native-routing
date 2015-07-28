#import "Routing.h"

@implementation BAMRouting

- (void)go:(CDVInvokedUrlCommand*)command
{

    NSString* callbackId = [command callbackId];
    NSString* segue = [[command arguments] objectAtIndex:0];
    NSString* withData = [[command arguments] objectAtIndex:1];

    CDVPluginResult* result = [CDVPluginResult
                               resultWithStatus:CDVCommandStatus_OK
                               messageAsString:msg];

    NSString *valueToSave = withData;
    [[NSUserDefaults standardUserDefaults] setObject:withData forKey:@"specialEdition"];
    [[NSUserDefaults standardUserDefaults] synchronize];


    [self.viewController performSegueWithIdentifier:segue sender:self];

    [self success:result callbackId:callbackId];
}

@end
