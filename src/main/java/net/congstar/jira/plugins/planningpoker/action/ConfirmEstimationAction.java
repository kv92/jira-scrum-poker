package net.congstar.jira.plugins.planningpoker.action;

import com.atlassian.jira.web.action.JiraWebActionSupport;
import net.congstar.jira.plugins.planningpoker.data.StoryPointFieldSupport;

public class ConfirmEstimationAction extends JiraWebActionSupport {

    private final StoryPointFieldSupport storyPointFieldSupport;

    public ConfirmEstimationAction(StoryPointFieldSupport storyPointFieldSupport) {
        this.storyPointFieldSupport = storyPointFieldSupport;
    }

    @Override
    protected String doExecute() throws Exception {
        String issueKey = request.getParameter("issueKey");
        String finalVote = request.getParameter("finalVote");

        storyPointFieldSupport.save(issueKey, new Double(finalVote));

        return getRedirect("/browse/" + issueKey);
    }

}
