setwd("/Users/awesomedude123/Desktop/Programming/R")
install.packages("foreign")
library(foreign)
data_spss <- read.spss("sra 365 lab 3 data.sav",use.value.labels=TRUE,to.data.frame=TRUE)
##read.csv("file.csv",header=TRUE)
##read.delim("file.dat",header=TRUE)
mean_per_sensitive <- mean(data_spss$per_sensitive)
sd_per_sensitive <- sd(data_spss$per_sensitive)
data_spss$z_score <- (data_spss$per_sensitive-mean_per_sensitive)/sd_per_sensitive
install.packages("ggplot2")
library(ggplot2)

plot1 <- ggplot(hw4.data,aes(employment_duration,age))
plot1 + geom_boxplot()

hist <- ggplot(hw4.data,aes(age))
hist + geom_histogram(binwidth = 0.5) +labs(x="Age",y="Frequency")

bar <- ggplot(hw.data,aes(age, count,fill=cool))
bar + stat_summary(fun.y=mean,geom="bar",position="dodge")