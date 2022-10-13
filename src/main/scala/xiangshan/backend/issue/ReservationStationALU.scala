/***************************************************************************************
* Copyright (c) 2020-2021 Institute of Computing Technology, Chinese Academy of Sciences
* Copyright (c) 2020-2021 Peng Cheng Laboratory
*
* XiangShan is licensed under Mulan PSL v2.
* You can use this software according to the terms and conditions of the Mulan PSL v2.
* You may obtain a copy of Mulan PSL v2 at:
*          http://license.coscl.org.cn/MulanPSL2
*
* THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND,
* EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT,
* MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
*
* See the Mulan PSL v2 for more details.
***************************************************************************************/

package xiangshan.backend.issue

import chipsalliance.rocketchip.config.Parameters
import chisel3._
import chisel3.util._
import freechips.rocketchip.diplomacy.{LazyModule, LazyModuleImp}

case class ALURSParams()

trait ALURSMod extends RSSubMod {
  override def rsGen: (RSParams, Parameters) => ALURS =
    (a: RSParams, b: Parameters) => new ALURS(a)(b)
  override def rsIOGen: (RSParams, Parameters) => ALURSIO =
    (a: RSParams, b: Parameters) => new ALURSIO(a)(b)
}

class ALURSWrapper(implicit p: Parameters) extends BaseReservationStationWrapper {
  override lazy val module = new ALURSImp(params, this)
}

class ALURSIO(params: RSParams)(implicit p: Parameters) extends BaseReservationStationIO(params)

class ALURSImp(params: RSParams, wrapper: ALURSWrapper) extends BaseReservationStationImp(params, wrapper) {
}

class ALURS(params: RSParams)(implicit p: Parameters) extends BaseReservationStation(params)