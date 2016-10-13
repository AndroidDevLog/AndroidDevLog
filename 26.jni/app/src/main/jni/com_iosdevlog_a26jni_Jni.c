//
// Created by iOS Dev Log on 2016/10/13.
//

#include "com_iosdevlog_a26jni_Jni.h"

JNIEXPORT jstring JNICALL Java_com_iosdevlog_a26jni_Jni_getJniString
  (JNIEnv *env, jobject obj) {
    return (*env)->NewStringUTF(env, "This is 'Hello World!' from JNI!");
}