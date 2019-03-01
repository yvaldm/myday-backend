package com.yvaldm.myday.mydaybackend.controller;

import com.yvaldm.myday.mydaybackend.api.ActionResponse;
import com.yvaldm.myday.mydaybackend.service.ActionService;
import com.yvaldm.myday.mydaybackend.transformers.Transformer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActionsController {

    private final ActionService actionService;

    public ActionsController(ActionService actionService) {
        this.actionService = actionService;
    }

    @GetMapping("/actions")
    public List<ActionResponse> findActions() {
        return Transformer.actionsToResponses(actionService.findActions());
    }
}
