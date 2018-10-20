  <section class="content">
                <!-- Small boxes (Stat box) -->
                <div class="row">
                    <div class="col-xs-12">
                        <div class="box contentbody">

                            <!--Parent Table-->
                            <table class="table table-bordered table-striped" id="parenttable">
                                <thead>
                                    <tr class="row_table">
                                        <th>Date time</th>
                                        <th>File Path</th>
                                        <th>Total</th>
                                        <th>Sent success</th>
                                        <th>Sent failed</th>
                                        <th>In Queue</th>
                                        <th>Status</th>
                                        <th>Detail</th>
                                        <th>Control</th>
                                        <th>Delete</th>
                                    </tr>
                                </thead>
                            </table>

                            <div class="modal fade" id="detail-modal">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title">SMS Batch detail</h4>
                                        </div>
                                        <div class="modal-body">
                                            <table class="table table-bordered table-striped" id="maintable">
                                                <thead>
                                                    <tr>
                                                        <th>No.</th>
                                                        <th>Phone Number</th>
                                                        <th>Name</th>
                                                        <th>Sent time</th>
                                                        <th>Text Message</th>
                                                        <th>Unicode</th>
                                                        <th>Error Message</th>
                                                    </tr>
                                                </thead>
                                            </table>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>

                            <div class="modal fade" id="number-modal">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title">Import Result</h4>
                                        </div>
                                        <div class="modal-body">
                                           <h4 id="number_success">Success Number : </h4>
                                           <h4 id="number_failed">Failed Number  : </h4>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </section>