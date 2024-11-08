package com.planifai.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Marta Rosado Nabais
 */
public class MainFrameTest {

    MainFrame mainFrame;

    public MainFrameTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        mainFrame = new MainFrame();

    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of cargarAulas method, of class MainFrame.
     */
    @Test
    public void testCargarAulas() {
        System.out.println("cargarAulas");
        MainFrame instance = new MainFrame();
        instance.cargarAulas();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarEventos method, of class MainFrame.
     */
    @Test
    public void testCargarEventos() {
        System.out.println("cargarEventos");
        MainFrame instance = new MainFrame();
        instance.cargarEventos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarDocumentos method, of class MainFrame.
     */
    @Test
    public void testCargarDocumentos() {
        System.out.println("cargarDocumentos");
        MainFrame instance = new MainFrame();
        instance.cargarDocumentos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class MainFrame.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MainFrame.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onAulaChanged method, of class MainFrame.
     */
    @Test
    public void testOnAulaChanged() {
        System.out.println("onAulaChanged");
        MainFrame instance = new MainFrame();
        instance.onAulaChanged();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
