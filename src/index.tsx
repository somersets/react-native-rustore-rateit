import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-rustore-rateit' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

const RustoreRateit: IRustoreRateit = NativeModules.RustoreRateit
  ? NativeModules.RustoreRateit
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

interface IRustoreRateit {
  runReviewFlow: () => Promise<string>;
}

export async function runReviewFlow(): Promise<string> {
  return RustoreRateit.runReviewFlow();
}
