package edu.psu.ist.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class SkillTableModel extends AbstractTableModel{
    private String[] columnNames = {"Name", "Description", "Majors","Interests","Ways to Learn","Expert Name"};
    private List<Skill> skillsList;

    public SkillTableModel(List<Skill> skillsList) {
        this.skillsList = skillsList;
    }


    @Override
    public int getRowCount() {
        return this.skillsList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 -> {
                return (Object) this.skillsList.get(rowIndex).getName();
            }
            case 1 -> {
                return (Object) this.skillsList.get(rowIndex).getDescription();
            }
            case 2 -> {
                String major="";
                Skill skill = this.skillsList.get(rowIndex);
                for(int i=0;i<skill.getMajors().size();i++){
                    if(i==skill.getMajors().size()-1){
                        major+=skill.getMajors().get(i).getName();
                    }else{
                        major=major+skill.getMajors().get(i).getName()+",";
                    }
                }//end for loop
                return (Object) major;
            }
            case 3 -> {
                String interest="";
                Skill skill = this.skillsList.get(rowIndex);
                for(int i=0;i<skill.getInterests().size();i++){
                    if(i==skill.getInterests().size()-1){
                        interest+=skill.getInterests().get(i).getName();
                    }else{
                        interest=interest+skill.getInterests().get(i).getName()+",";
                    }
                }//end for loop
                return (Object) interest;
            }
            case 4 -> {
                String waysToLearn="";
                Skill skill = this.skillsList.get(rowIndex);
                for(int i=0;i<skill.getWaysToLearn().size();i++){
                    if(i==skill.getWaysToLearn().size()-1){
                        waysToLearn+=skill.getWaysToLearn().get(i);
                    }else{
                        waysToLearn=waysToLearn+skill.getWaysToLearn().get(i)+",";
                    }
                }//end for loop
                return (Object) waysToLearn;
            }
            case 5 -> {
                return (Object) this.skillsList.get(rowIndex).getExpertName();
            }
        }
        return null;
    }

    public Skill getSkill(int rowIndex){
        return this.skillsList.get(rowIndex);
    }

    public void setSkills(List<Skill> skillList) {
        this.skillsList=skillList;
    }

    public List<Skill> getSkills(){
        return this.skillsList;
    }


}
