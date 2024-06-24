package edu.psu.ist.model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class RecommendationTableModel extends AbstractTableModel {

    private String[] columnNames = {"Name", "Skills", "Majors", "Interests", "Progress", "Is Completed?"};

    private List<Recommendation> recommendations;

    public RecommendationTableModel(){
        this.recommendations = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return this.recommendations.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return this.recommendations.get(rowIndex).getName();
            }
            case 1 -> {
                String skills="";
                Recommendation rec = this.recommendations.get(rowIndex);
                for(int i=0; i<rec.getSkills().size();i++){
                    if(i==rec.getSkills().size()-1){
                        skills+=rec.getSkills().get(i).getName();
                    }else{
                        skills = skills+rec.getSkills().get(i).getName()+",";
                    }
                }
                return (Object) skills;
            }
            case 2 -> {
                String major="";
                Recommendation rec = this.recommendations.get(rowIndex);
                for(int i=0;i<rec.getMajors().size();i++){
                    if(i==rec.getMajors().size()-1){
                        major+=rec.getMajors().get(i).getName();
                    }else{
                        major=major+rec.getMajors().get(i).getName()+",";
                    }
                }//end for loop
                return (Object) major;
            }
            case 3 -> {
                String interest="";
                Recommendation rec = this.recommendations.get(rowIndex);
                for(int i=0;i<rec.getInterests().size();i++){
                    if(i==rec.getInterests().size()-1){
                        interest+=rec.getInterests().get(i).getName();
                    }else{
                        interest=interest+rec.getInterests().get(i).getName()+",";
                    }
                }//end for loop
                return (Object) interest;
            }
            case 4 -> {
                return this.recommendations.get(rowIndex).getProgress();
            }
            case 5 -> {
                return this.recommendations.get(rowIndex).isCompleted();
            }
        }
        return null;
    }//end value method

    public Recommendation getRecommendation(int rowIndex){
        return this.recommendations.get(rowIndex);
    }

    public void setRecommendations(List<Recommendation> recommendations){
        this.recommendations=recommendations;
    }

    public List<Recommendation> getRecommendations(){
        return this.recommendations;
    }

    @Override
    public String getColumnName(int col){
        return this.columnNames[col];
    }


}
