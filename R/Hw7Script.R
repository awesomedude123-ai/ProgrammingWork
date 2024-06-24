install.packages("foreign")
library(foreign)

install.packages("leaps")
library(leaps)

install.packages("car")
library(car)

hw7.data <- read.csv("hw7-1.csv",header=TRUE)

bestsubsets = regsubsets(freq ~ content_length + 
                           tcp_conversation_exchange + remote_ips + 
                           app_packets + dns_query_times,data = hw7.data, 
                         nbest = 1)

subsets(bestsubsets,statistic = "adjr2")

Model1 <- lm(freq ~ dns_query_times,data=hw7.data)
summary(Model1)

Model2 <- lm(freq ~ dns_query_times + remote_ips,data = hw7.data)
summary(Model2)

Model3 <- lm(freq ~ dns_query_times + remote_ips + app_packets,data = hw7.data)
summary(Model3)

Model4 <- lm(freq ~ dns_query_times + remote_ips + app_packets + content_length,data = hw7.data)
summary(Model4)

Model5 <- lm(freq ~ dns_query_times + remote_ips + app_packets + content_length + tcp_conversation_exchange,data = hw7.data)
summary(Model5)

vif(Model5)

1/vif(Model5)

cor(hw7.data[,c("dns_query_times","remote_ips","app_packets","content_length","tcp_conversation_exchange")])