# react-native-rustore-rateit

ReactNative RuStore SDK for comments and ratings an app

### Для поддержки проекта
### https://www.tinkoff.ru/cf/1to7PiSSNzj

## Installation

```sh
npm install @somersets/react-native-rustore-rateit
```

## Usage

```ts
import { runReviewFlow } from '@somersets/react-native-rustore-rateit';

const response = await runReviewFlow();
```
#### response = "SUCCESS" || Сообщение ошибки
Ошибки см. https://help.rustore.ru/rustore/for_developers/developer-documentation/SDK-reviews-ratings/SDK-reviews-ratings-android/possible-errors


```
  android/build.gradle

  allprojects {
      repositories {
          ...
          maven {
              url("https://artifactory-external.vkpartner.ru/artifactory/maven")
          }
      }
  }
```
---
```
android/app/build.gradle

dependencies {
    ...
    implementation("ru.rustore.sdk:billingclient:0.1.6")
}
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
