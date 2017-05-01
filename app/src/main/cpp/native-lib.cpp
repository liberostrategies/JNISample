#include <jni.h>
#include <string>


extern "C"
JNIEXPORT jstring JNICALL
Java_com_liberostrategies_jnisample_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "C++ wants you to click a triangle name";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT void JNICALL
Java_com_liberostrategies_jnisample_Triangle_drawTriangleFromJNI(
        JNIEnv *env,
        jobject triangle ) {
    // Call OpenGL Triangle.draw().
    jclass clazzTriangle = env->FindClass("com/liberostrategies/jnisample/Triangle");
    jmethodID  methodDraw = env->GetMethodID(clazzTriangle, "draw", "()V");
    env->CallVoidMethod(triangle, methodDraw);
}