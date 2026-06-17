package com.sdp.invoiceflow.theming.exceptions;

public final class MalformedJsonAsColorThemeException extends Exception{
    public MalformedJsonAsColorThemeException(final String filePath) {
        super(String.format("Malformed json passed as color theme in file: '%s'", filePath));
    }
}
