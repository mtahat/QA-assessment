package org.api.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.api.domain.MessageHandler;
import org.junit.Test;

public class MessageHandlerTest {

	
    @Test
    public void nullMessageisFoundReturnFalse() {
		assertFalse(MessageHandler.isFound(null));
    }
    
    @Test
    public void emptyMessageisFoundReturnFalse() {
		assertFalse(MessageHandler.isFound(""));
    }
    
    @Test
    public void matchNotFoundMessageisFoundReturnFalse() {
		assertFalse(MessageHandler.isFound("Match Not Found"));
    }
    
    @Test
    public void matchFoundMessageisFoundReturnTrue() {
		assertTrue(MessageHandler.isFound(MessageHandler.FOUND));
    }
    
    @Test
    public void processMessageReturnExitWhenCustomerInptExit() {
		assertEquals(MessageHandler.EXIT_MESSAGE, MessageHandler.processMessage(MessageHandler.EXIT));
    }
    
    @Test
    public void processMessageReturnSameMessageIfNotExit() {
		assertEquals("Test Message", MessageHandler.processMessage("Test Message"));
    }
    
}
