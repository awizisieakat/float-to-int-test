#include <jni.h>
#include "pkg_NativeConverter.h"

JNIEXPORT jint JNICALL Java_pkg_NativeConverter_convert(JNIEnv *env, jobject jobj, jfloat value) {
    return *((jint*)(&value));
}