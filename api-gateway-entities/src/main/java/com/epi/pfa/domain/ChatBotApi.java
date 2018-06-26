package com.epi.pfa.domain;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.*;
@Document(collection = "service")
@TypeAlias("chat-bot")
public class ChatBotApi extends Service {

}
