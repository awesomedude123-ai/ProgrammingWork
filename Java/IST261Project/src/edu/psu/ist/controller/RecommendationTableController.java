package edu.psu.ist.controller;

import edu.psu.ist.model.RecommendationTableModel;
import edu.psu.ist.view.RecommendationListView;
import edu.psu.ist.view.RecommendationView;

public class RecommendationTableController {
    public final RecommendationListView view;
    public final RecommendationTableModel model;

    public RecommendationTableController(RecommendationListView view, RecommendationTableModel model) {
        this.view = view;
        this.model = model;
        this.view.form.getRecommendationListTable().setModel(this.model);
        RecommendationController recommendationController = new RecommendationController(new RecommendationView(), new MajorController(), new InterestController(), new SkillController(),this);

        this.view.form.getNewButton().addActionListener(x -> {
            this.view.setVisible(false);
            recommendationController.view.setVisible(true);
        });

        this.view.form.getQuitButton().addActionListener(x -> {
            System.exit(1);
        });

        this.view.form.getShowDetailsButton().addActionListener(x -> {

        });
    }
}
