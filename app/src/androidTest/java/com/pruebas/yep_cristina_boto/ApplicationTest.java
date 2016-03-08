package com.pruebas.yep_cristina_boto;

import android.app.Application;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ApplicationTestCase;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;

import java.text.ParseException;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ActivityInstrumentationTestCase2<LoginActivity> {

    private Button btnLogin;
    private EditText textUser;
    private EditText textPass;
    private LoginActivity actividad;

    public ApplicationTest() {
        super(LoginActivity.class);
    }

    protected void setUp() throws Exception {

        super.setUp();

        actividad = getActivity();
        textUser = (EditText) actividad.findViewById(R.id.editUser);
        textPass = (EditText) actividad.findViewById(R.id.editPass);
        btnLogin = (Button) actividad.findViewById(R.id.btnAceptar);
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }


    private static final String USER = " ";
    private static final String PASS = " ";



    public void testLogin() {

        TouchUtils.tapView(this, textUser);
        getInstrumentation().sendStringSync(USER);
        TouchUtils.tapView(this, textPass);
        getInstrumentation().sendStringSync(PASS);
        TouchUtils.clickView(this, btnLogin);

        String loginUser = textUser.getText().toString();
        String loginPass = textPass.getText().toString();

        assertTrue("Add result 1 should be...", loginUser.equals(USER));
        assertTrue("Add result 2 should be...", loginPass.equals(PASS));

    }

}