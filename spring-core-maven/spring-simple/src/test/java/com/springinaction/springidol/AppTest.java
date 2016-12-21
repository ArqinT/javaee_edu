package com.springinaction.springidol;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by artemtursunov on 22.12.16.
 */
public class AppTest {
    @Test
    public void main() throws Exception {
        App app = new App();
        String[] args = {"test"};
        app.main(args);
    }

}