package iit.cs445.controllers;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class BracketControllerTest {
    @org.junit.Test
    public void add() throws Exception {
    }

    @org.junit.Test
    public void remove() throws Exception {
    }

    @org.junit.Test
    public void modify() throws Exception {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(BracketController.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
