package com.yvaldm.myday.mydaybackend.transformers;

import com.yvaldm.myday.mydaybackend.api.ActionPerformedResponse;
import com.yvaldm.myday.mydaybackend.api.ActionResponse;
import com.yvaldm.myday.mydaybackend.entity.Action;
import com.yvaldm.myday.mydaybackend.entity.ActionPerformed;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Transformer {

    public static List<ActionResponse> actionsToResponses(List<Action> actions) {
        return actions.stream().map(Transformer::actionToResponse).collect(toList());
    }

    public static ActionResponse actionToResponse(Action action) {
        return new ActionResponse(action.getId(), action.getName(), action.getRating());
    }

    public static List<ActionPerformedResponse> performedActionsToResponse(List<ActionPerformed> actionPerformed) {
        return actionPerformed.stream().map(Transformer::performedActionToResponse).collect(toList());
    }

    private static ActionPerformedResponse performedActionToResponse(ActionPerformed actionPerformed) {
        return new ActionPerformedResponse(actionPerformed.getId(), actionPerformed.getActionId(), actionPerformed.getUserId(), actionPerformed.getCts());
    }
}
