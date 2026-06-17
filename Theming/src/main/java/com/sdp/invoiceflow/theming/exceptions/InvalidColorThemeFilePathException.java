package com.sdp.invoiceflow.theming.exceptions;

public final class InvalidColorThemeFilePathException extends Exception {
    public InvalidColorThemeFilePathException(final String filePath) {
        super(String.format("Invalid color theme file path, can not load file '%s'", filePath));
    }
}
