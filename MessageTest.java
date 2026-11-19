package com.mycompany.poe1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

@Test
public void testMessageID() {
Message msg = new Message(
"+27718693002", "Hi Mike");
assertTrue(msg.checkMessageID());
}

@Test
public void testValidRecipient() {
Message msg = new Message(
"+27718693002", "Hello");
assertEquals(
"Cell phone number successfully captured.",
msg.checkRecipientCell());
}

@Test
public void testInvalidRecipient() {
Message msg = new Message(
"0718693002", "Hello");
assertTrue(msg.checkRecipientCell()
.contains("incorrectly formatted"));
}

@Test
public void testValidMessageLength() {
Message msg = new Message(
"+27718693002", "Hello Mike");
assertEquals("Message ready to send.",
msg.checkMessageLength());
}

@Test
public void testMessageTooLong() {
String longText = "A".repeat(251);

Message msg = new Message(
"+27718693002", longText);

assertTrue(msg.checkMessageLength()
.contains("exceeds 250 characters"));
}

@Test
public void testMessageHash() {
Message msg = new Message(
"+27718693002", "Hi Mike");

String hash = msg.createMessageHash();

assertTrue(hash.endsWith("HIMIKE"));
}

@Test
public void testSendMessage() {
Message msg = new Message(
"+27718693002", "Hello Mike");

assertEquals("Message successfully sent.",
msg.sentMessage(1));
}

@Test
public void testDisregardMessage() {
Message msg = new Message(
"+27718693002", "Hello Mike");

assertEquals("Press 0 to delete the message",
msg.sentMessage(2));
}

@Test
public void testPrintMessageDetails() {
Message msg = new Message(
"+27718693002", "Hello Mike");

String details = msg.printMessages();

assertTrue(details.contains("Message ID:"));
assertTrue(details.contains("Message Hash:"));
assertTrue(details.contains("+27718693002"));
assertTrue(details.contains("Hello Mike"));
}
}