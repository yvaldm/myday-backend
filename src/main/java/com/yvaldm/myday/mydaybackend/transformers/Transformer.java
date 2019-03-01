package com.yvaldm.myday.mydaybackend.transformers;

import com.yvaldm.myday.mydaybackend.api.ActionResponse;
import com.yvaldm.myday.mydaybackend.entity.Action;

import java.util.List;
import java.util.stream.Collectors;

public class Transformer {

    public static List<ActionResponse> actionsToResponses(List<Action> actions) {
        return actions.stream().map(Transformer::actionToResponse).collect(Collectors.toList());
    }

    public static ActionResponse actionToResponse(Action action) {
        return new ActionResponse(action.getName(), action.getRating());
    }
}
