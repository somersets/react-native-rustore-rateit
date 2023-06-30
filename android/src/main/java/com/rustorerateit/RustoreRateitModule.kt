package com.rustorerateit

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise
import ru.rustore.sdk.core.tasks.OnCompleteListener
import ru.vk.store.sdk.review.RuStoreReviewManagerFactory
import ru.vk.store.sdk.review.model.ReviewInfo

class RustoreRateitModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  private val manager = RuStoreReviewManagerFactory.create(reactContext)

  companion object {
    const val NAME = "RustoreRateit"
  }

  override fun getName(): String {
    return NAME
  }

  @ReactMethod
  fun runReviewFlow(promise: Promise) {
    manager.requestReviewFlow().addOnCompleteListener(object : OnCompleteListener<ReviewInfo> {
      override fun onFailure(throwable: Throwable) {
        promise.resolve(throwable.message)
      }

      override fun onSuccess(result: ReviewInfo) {
        launchReviewFlow(result, promise)
      }
    })
  }

  private fun launchReviewFlow(reviewInfo: ReviewInfo, promise: Promise) {
    manager.launchReviewFlow(reviewInfo).addOnCompleteListener(object: OnCompleteListener<Unit> {
      override fun onFailure(throwable: Throwable) {
        promise.resolve(throwable.message)
      }

      override fun onSuccess(result: Unit) {
        promise.resolve("SUCCESS")
      }
    })
  }
}
