package com.selenium.project.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static void captureScreenshot(
            WebDriver driver,
            String testName) {

        try {

            // Take screenshot
            File source =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);

            // Create screenshot directory
            File screenshotDirectory =
                    new File("target/screenshots");

            if (!screenshotDirectory.exists()) {
                screenshotDirectory.mkdirs();
            }

            // Create screenshot file
            File destination =
                    new File(
                        screenshotDirectory,
                        testName + ".png"
                    );

            // Copy screenshot
            Files.copy(
                    source.toPath(),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println(
                "========================================"
            );

            System.out.println(
                "Screenshot saved successfully:"
            );

            System.out.println(
                destination.getAbsolutePath()
            );

            System.out.println(
                "========================================"
            );

        } catch (Exception e) {

            System.out.println(
                "Screenshot capture failed: "
                + e.getMessage()
            );

            e.printStackTrace();
        }
    }
}