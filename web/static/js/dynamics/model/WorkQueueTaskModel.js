var WorkQueueTaskModel = function WorkQueueTaskModel() {
  TaskModel.call(this);
  this.copiedFields.workQueueRank = "workQueueRank";
  this.persistedClassName = "fi.hut.soberit.agilefant.transfer.DailyWorkTaskTO";
};
extendObject(WorkQueueTaskModel, TaskModel)
WorkQueueTaskModel.prototype.getWorkQueueRank = function() {
  return this.currentData.workQueueRank;
};
WorkQueueTaskModel.prototype.rankInWorkQueue = function(previousTaskId) {
  var me = this;
  $.ajax({
    url:  'ajax/rankDailyTaskAndMoveUnder.action',
    data: { taskId: this.id, rankUnderId: previousTaskId },
    type: "post",
    success: function(data, status) {
      MessageDisplay.Ok("Task ranked in work queue");
      me.callListeners(new DynamicsEvents.RankChanged(me, "workQueueTask"));
    }
  });
};