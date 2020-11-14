/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kuzner
 */
public class SettingsLoader {

    private static SettingsLoader instance;
    private Properties props;
    OutputStream output = null;

    private SettingsLoader() {
        try {
            props = new Properties();
            props.load(new FileInputStream("settings.properties"));
        } catch (Exception ex) {
            Logger.getLogger(SettingsLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static SettingsLoader getInstance() {
        if (instance == null) {
            instance = new SettingsLoader();
        }
        return instance;
    }

    public String getProperty(String key) {
        return props.getProperty(key, "n/a");
    }

    public void SetPropery(String key, String value) {
        props.setProperty(key, value);
    }

    public void setProperty(String port, String url, String user, String password) {
        try {
            output = new FileOutputStream("settings.properties");

            props.setProperty("port", port);
            props.setProperty("url", url);
            props.setProperty("user", user);
            props.setProperty("password", password);
            
            props.store(output, null);
        } catch (IOException ex) {
            Logger.getLogger(SettingsLoader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
		if (output != null) {
			try {
				output.close();
			} catch (IOException e) {
				
			}
		}

	}

    }
}
