package com.mt_java_webserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.sun.net.httpserver.HttpServer;

import methodhandlers.BaseHandler;
import methodhandlers.FileManager;

/**
 * This is the main class for the web server
 * 
 */
public class MainApp
{
    private static final int MAX_THREADS  = 10;
    static int               port;
    static HttpServer        httpServer;
    static final int         DEFAULT_PORT = 4444;

    /**
     * Logger
     */
    final static Logger      _logger      = Logger.getLogger(MainApp.class);

    public static void main(String[] args)
    {
        if ( args.length != 0 )
        {
            port = Integer.parseInt(args[0]);
        }
        else
        {
            port = DEFAULT_PORT;
        }
        startServer(port);
    }

    public static void startServer(int port)
    {
        try
        {
            httpServer = HttpServer.create(new InetSocketAddress("localhost", port), 0);
            httpServer.createContext("/", new BaseHandler());
            httpServer.createContext("/v1/file", new FileManager());
            httpServer.setExecutor(Executors.newFixedThreadPool(MAX_THREADS));
            httpServer.start();
        }
        catch (IllegalArgumentException ex)
        {
            _logger.error("Error in MainApp:IllegalArgumentException:" + ex.getMessage());
        }
        catch (IOException e)
        {
            _logger.error("Error in MainApp:IOException:" + e.getMessage());
        }
    }

    /**
     * Stops the HttpServer
     */
    public static void stopServer()
    {
        httpServer.stop(0);
    }
}
