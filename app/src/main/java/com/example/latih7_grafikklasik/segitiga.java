package com.example.latih7_grafikklasik;

import androidx.appcompat.app.AppCompatActivity;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView;

public class segitiga implements GLSurfaceView.Renderer {
    private FloatBuffer triangle;
    public void onSurfaceCreated(GL10 gl,EGLConfig config) {
        gl.glClearColor(0.0f, 0.0f, 0.9f, 1.0f );
        initShapes();
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
    }

    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glColor4f(0.0f, 1.0f, 0.0f, 0.0f);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, triangle);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);
    }

    public void onSurfaceChanged(GL10 gl, int width, int height){
        gl.glViewport(0,0, width, height);
    }

    private void initShapes(){
        float vertices[]={
                -0.6f, -0.5f, 0,
                0.6f, -0.5f, 0,
                0.0f, 0.5f, 0
        };

        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length*4);
        vbb.order(ByteOrder.nativeOrder());
        triangle = vbb.asFloatBuffer();
        triangle.put(vertices);
        triangle.position(0);
    }
}

