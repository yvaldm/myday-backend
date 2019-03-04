package com.yvaldm.myday.mydaybackend.controller;

import com.yvaldm.myday.mydaybackend.api.ActionPerformedResponse;
import com.yvaldm.myday.mydaybackend.service.ActionService;
import com.yvaldm.myday.mydaybackend.transformers.Transformer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller tracking actions of a specific users
 *
 * @author valery.yakovlev
 */
@RestController
public class ActionsTrackingController {

    private final ActionService actionService;

    public ActionsTrackingController(ActionService actionService) {
        this.actionService = actionService;
    }

    @PostMapping("/user/{userId}/actions/{actionId}")
    public void trackAction(@PathVariable String userId, @PathVariable long actionId) {
        actionService.trackAction(userId, actionId);
    }

    @GetMapping("/user/{userId}/actions")
    public List<ActionPerformedResponse> loadTrackedActions(@PathVariable String userId) {
        return Transformer.performedActionsToResponse(actionService.findTrackedActions(userId));
    }
}
