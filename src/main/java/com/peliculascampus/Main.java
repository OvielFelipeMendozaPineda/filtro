package com.peliculascampus;

import com.peliculascampus.actor.infrastructure.adapter.in.ActorController;

public class Main {
    public static void main(String[] args) {
        
        ActorController controller = new ActorController();
        controller.actorMenu();
    }
}