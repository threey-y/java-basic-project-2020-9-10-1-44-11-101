package com.thoughtworks.basic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ArgsTest {
    @Test
    public void should_return_defaultValue_when_inputArgs_without_value() throws Exception {
        String inputArgs = "-l  -p  -d ";

        Args args = new Args(inputArgs);

        assertEquals("[Arg{flag='l  ', value=false, type='boolean'}, " +
                        "Arg{flag='p  ', value=0, type='int'}, " +
                        "Arg{flag='d ', value=, type='String'}]"
                ,args.getArgList().toString());
    }

    @Test
    public void should_throw_value_no_legal_when_error_value() throws Exception {
        String inputArgs = "-l -true";

        try {
            Args args = new Args(inputArgs);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            assertThat(exception.getMessage(), is("value不能以-开头"));
        }
    }

    @Test
    public void should_return_args_when_inputArgs() throws Exception {
        String inputArgs = "-l true -p 8080 -d /usr/logs";

        Args args = new Args(inputArgs);

        assertEquals("[Arg{flag='l', value=true, type='boolean'}, " +
                        "Arg{flag='p', value=8080, type='int'}, " +
                        "Arg{flag='d', value=/usr/logs, type='String'}]"
                ,args.getArgList().toString());
    }

}
