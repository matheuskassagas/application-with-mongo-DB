package applicationwithmongoDB.controller.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

// classe para formatar a string da url para o padrao de busca
public class URL {

    public static String decodeParam(String text) {
        try{
            return URLDecoder.decode(text, "UTF-8");
        }catch (UnsupportedEncodingException e){
            return "";
        }
    }
}
